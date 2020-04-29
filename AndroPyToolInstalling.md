## Ghi chép về công cụ Andropytool tính năng phân tích tĩnh và động ứng dụng android  
## I. giới thiệu 
### 1. Nhóm tác giả và thông tin thêm về đề tài :
-   Martín, A., Lara-Cabrera, R., & Camacho, D. (2018). [Android malware detection through hybrid features fusion and ensemble classifiers: the AndroPyTool framework and the OmniDroid dataset.](https://www.researchgate.net/publication/329745168_Android_malware_detection_through_hybrid_features_fusion_and_ensemble_classifiers_the_AndroPyTool_framework_and_the_OmniDroid_dataset?_sg=YV6P1W_i0faZ9O-N9ZX304ZuP75Je8qHk5jvYW3jT-kEFaaY1uN9IkeIWRItR8eCgTAWp28TZqGngLStCSjUge2E6RkQ1cbejyPVMqlN.pDLH4lsRw1zTXkacv0O9DQH1k99crDqqV-qmERjUZH6bSMvQR9kGZekM-lFpDeH0n4zVwUF8oNkN819nQeo70w) Information Fusion. DOI: 10.1016/j.inffus.2018.12.006
    
-   Martín, A., Lara-Cabrera, R., & Camacho, D. (2018). [A new tool for static and dynamic Android malware analysis.](https://www.researchgate.net/publication/326717726_A_new_tool_for_static_and_dynamic_Android_malware_analysis?_sg=WwRuFx8WLxsh3FenraVpg5RM-Zhhl9UI-AW2mjDUutM2khyHoJSyjQT9xPxL8sapMGs61NrPt7msKZHac_-I686DJkK0tfEZXGunKJHl.iOVVyaQ7BRuy1Uk1vk2KbcpIZmFBUee_2DMX9-7WedzWpw4GHAsTcGPB6AGdWE0eMnjqaRn2ukj6mD3cAL3vHA) In Data Science and Knowledge Engineering for Sensing Decision Support (pp. 509-516). World Scientific.
- Github-[alexMyG](https://github.com/alexMyG/AndroPyTool)
### 2. Tổng quan về AndroPyTool :
Đây là một công cụ được viết bằng Python với mục đích trích xuất thông tin sử dụng tính năng bao gồm phân tích  **tĩnh**(static) và **động** (dynamic) từ một file ứng dụng android **[APK](h)** . Nó là sự kết hợp các công cụ phân tích ứng dụng Android nổi tiếng khác nhau như  **[DroidBox](h)**, **[FlowDroid](h)**, **[Strace](h)**, **[AndroGuard](h)** hoặc **[VirusTotal](h)**. Được cung cấp một thư mục nguồn chứa các tệp APK, AndroPyTool áp dụng tất cả các công cụ này để thực hiện phân tích tĩnh và động và sử dụng các file  **JSON** và **CSV** cho phép lưu tất cả dữ liệu trong cơ sở dữ liệu **[MongoDB](h)**.

Mô hình hoạt động của công cụ này :

![alt text](https://raw.githubusercontent.com/alexMyG/AndroPyTool/master/AndroPyTool.png)
## II. Cài đặt và sử dụng 
### 1. Cài đặt 
Có hai cách để cài đặt công cụ AndroPyTool :  
- Cách 1: Sử dụng **Docker**
- Cách 2: Cài bằng mã nguồn trên **Ubuntu** (source code) 

#### A. Cài đặt sử dụng docker 
Khi sử dụng Docker thì chúng ta chỉ cần thực hiện hai bước đó là cài đặt Docker  và Pull image + Run Container  là đã xong khâu cài đặt .
- Cài Docker, nếu bạn chưa từng cài Docker hay sử dụng nó một cách căn bản thì hãy tham khảo bài viết của tôi **[tại đây](https://github.com/ErikHorus1249/Guide-Documents/tree/master/G_Docker)**.
- Khởi động Docker lên và pull image từ Dockerhub bạn sử dụng lệnh sau :

> $ docker pull alexmyg/andropytool
- Khởi động AndroPyTool bằng cách khởi tạo và chạy Container từ image mà bạn đã pull về :
> 
> 
> `$ docker run --volume=</PATH/TO/FOLDER/WITH/APKS/>:/apksalexmyg/andropytool -s /apks/ <ARGUMENTS>`

- Theo tôi trước khi sử dụng câu lệnh trên bạn nên tạo trước một Volume thay vì mount trực tiếp mỗi lần lại phải chèn path vào.
ví dụ ở đây là tôi sẽ đặt một file apk và cả image của thiết bị android mà bạn sẽ cần ở những bước sau ở `/home/lab` . Tại vì sẽ phát sinh lỗi ở Androibox thầy của tôi đã tìm ra cách fix nó hãy chú ý nhé. Một volume là `disk1` sẽ  được khởi tạo từ  `/home/lab`

> `$ docker volume create --opt device=/home/lab --opt type=none --opt
> o=bind disk1`

Sau đó tôi sẽ chạy AndroPyTool tại host này tôi cũng sẽ tạo một folder lab trong home để mount với disk1: 

    

> `$ docker run -v disk1:/home/lab:/apks alexmyg/andropytool -s /apks/ <ARGUMENTS>`

**Note 1** là không được thiếu tham chiếu `-s` trong lệnh trên, nó sẽ trỏ đến thư mục apk nơi sẽ thực thi phân tích.
**Note 2** AndroPyTool di chuyển các tệp APK của bạn sang thư mục con khác để tạo thư mục làm việc có tổ chức. Xem sơ đồ cấu trúc thư mục. Đó chính là thư mục `/samples`

#### Các tính năng được cung cấp bởi AndroPyTool
-   `-h`: hiển thị thông báo trợ giúp và thoát.
-   `-all`, `--allsteps`: Thực thi tất cả các bước của AndroPyTool . Để có được báo cáo VirusTotal, đối số -vt cũng phải được cung cấp kèm theo khóa API VirusTotal. Nếu bạn không chọn tùy chọn -all , thì chỉ thực thi bước được cung cấp đối số và bước cuối cùng được thực hiện.
-   `-s SOURCE_FOLDER`, `--source SOURCE_FOLDER`: Thư mục chứa APK cần phân tích. Tất cả các mẫu phải có phần mở rộng .apk . Nếu việc thực thi AndroPyTool trước đó bị gián đoạn, thư mục làm việc trước đó bạn phải cung cấp lại.
-   `-S`, `--single`: Lưu phân tích duy nhất riêng biệt. Mặc định: false.
-   `-f`, `--filter`: Lọc APK hợp lệ và không hợp lệ (Recommended).
-   `-vt VIRUSTOTAL_API_KEY`, `--virustotal VIRUSTOTAL_API_KEY`: Phân tích các ứng dụng với dịch vụ VirusTotal. Nó phải được theo sau bởi khóa API VirusTotal.
-   `-cl`, `--classify`:Phân loại ứng dụng giữa phần mềm độc hại hoặc phần mềm lành tính dựa trên báo cáoVirusTotal. Đối số -virustotal phải được thiết lập.
-   `-fw`, `--flowdroid`:Chạy flowdroid.
-   `-dr`, `--droidbox`: Chạy droidbox.
-   `-c`, `--cleanup`: Thực hiện dọn dẹp xóa các tập tin làm việc tạm thời. Mặc định: True
-   `-P PACKAGEINDEX`, `--packgeIndex PACKAGEINDEX`: TXT file with all Android API packages. Default: info/package_index.txt
-   `-C CLASSINDEX`, `--classIndex CLASSINDEX`: TXT file with all Android API classes. Default: info/class_index.txt
-   `-C CLASSINDEX`, `--classIndex CLASSINDEX`: TXT file with all Android API classes. Default: info/class_index.txt
-   `-SC SYSTEMCOMMANDSINDEX`, `--systemCommandsIndex SYSTEMCOMMANDSINDEX`: Tệp TXT với tất cả các gói API Android. Mặc định: info/system_commands.txt
-   `-C CLASSINDEX`, `--classIndex CLASSINDEX`: Tệp TXT với tất cả các lớp API Android. Mặc định : info/class_index.txt
-   `-mg MONGODBURI`, `--mongodbURI MONGODBURI`: Xuất khẩu báo cáo được tạo ra một cơ sở dữ liệu mongodb. Yêu cầu địa chỉ kết nối theo đường dẫn: localhost: 27017
-   `-csv EXPORTCSV`, `--cexportCSV EXPORTCSV`: Xuất báo cáo được tạo thành tệp CSV. Chỉ  bao gồm các tính năng tĩnh.
-   `--color`: Cho hiển thị  màu sắc  tin nhắn.
-   `--no-color`:  Không cho phép hiển thị  màu sắc  tin nhắn.
