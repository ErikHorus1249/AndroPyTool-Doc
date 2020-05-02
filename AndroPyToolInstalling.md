


By **[Erik Horus](https://github.com/ErikHorus1249)**
Date : 30/04/2020 

## Ghi chép về công cụ Andropytool  phân tích tĩnh và động ứng dụng android  
## I. giới thiệu 
### 1. Nhóm tác giả và thông tin thêm về đề tài :
-   Martín, A., Lara-Cabrera, R., & Camacho, D. (2018). [Android malware detection through hybrid features fusion and ensemble classifiers: the AndroPyTool framework and the OmniDroid dataset.](https://www.researchgate.net/publication/329745168_Android_malware_detection_through_hybrid_features_fusion_and_ensemble_classifiers_the_AndroPyTool_framework_and_the_OmniDroid_dataset?_sg=YV6P1W_i0faZ9O-N9ZX304ZuP75Je8qHk5jvYW3jT-kEFaaY1uN9IkeIWRItR8eCgTAWp28TZqGngLStCSjUge2E6RkQ1cbejyPVMqlN.pDLH4lsRw1zTXkacv0O9DQH1k99crDqqV-qmERjUZH6bSMvQR9kGZekM-lFpDeH0n4zVwUF8oNkN819nQeo70w) Information Fusion. DOI: 10.1016/j.inffus.2018.12.006
    
-   Martín, A., Lara-Cabrera, R., & Camacho, D. (2018). [A new tool for static and dynamic Android malware analysis.](https://www.researchgate.net/publication/326717726_A_new_tool_for_static_and_dynamic_Android_malware_analysis?_sg=WwRuFx8WLxsh3FenraVpg5RM-Zhhl9UI-AW2mjDUutM2khyHoJSyjQT9xPxL8sapMGs61NrPt7msKZHac_-I686DJkK0tfEZXGunKJHl.iOVVyaQ7BRuy1Uk1vk2KbcpIZmFBUee_2DMX9-7WedzWpw4GHAsTcGPB6AGdWE0eMnjqaRn2ukj6mD3cAL3vHA) In Data Science and Knowledge Engineering for Sensing Decision Support (pp. 509-516). World Scientific.
- Github-[alexMyG](https://github.com/alexMyG/AndroPyTool)
### 2. Tổng quan về AndroPyTool :
Đây là một công cụ được viết bằng Python với mục đích trích xuất thông tin sử dụng tính năng bao gồm phân tích  **tĩnh**(static) và **động** (dynamic) từ một file ứng dụng android **[APK](h)** . Nó là sự kết hợp các công cụ phân tích ứng dụng Android nổi tiếng khác nhau như  **[DroidBox](h)**, **[FlowDroid](h)**, **[Strace](h)**, **[AndroGuard](h)** hoặc **[VirusTotal](h)**. Được cung cấp một thư mục nguồn chứa các tệp APK, AndroPyTool áp dụng tất cả các công cụ này để thực hiện phân tích tĩnh và động và sử dụng các file  **JSON** và **CSV** cho phép lưu tất cả dữ liệu trong cơ sở dữ liệu **[MongoDB](h)**.

Mô hình hoạt động của công cụ này :

![AndroPytool architecture.](https://www.researchgate.net/profile/Alejandro_Martin_Garcia/publication/326717726/figure/fig1/AS:674340567777280@1537786728580/AndroPytool-architecture.png)
## II. Cài đặt và sử dụng 
### 1. Cài đặt 
Có hai cách để cài đặt công cụ AndroPyTool :  
- Cách 1: Sử dụng **Docker**
- Cách 2: Cài bằng mã nguồn trên **Ubuntu** (source code) 

#### A. Cài đặt sử dụng docker 
Khi sử dụng Docker thì chúng ta chỉ cần thực hiện các bước đó là cài đặt Docker ,  **Pull image** và **Run Container**  là đã xong bước cài đặt .
- Cài đặt Docker, nếu bạn chưa từng cài Docker hay sử dụng nó một cách căn bản thì hãy tham khảo bài viết của tôi **[tại đây](https://github.com/ErikHorus1249/Guide-Documents/tree/master/G_Docker)**.
- Khởi động Docker lên và pull image từ Dockerhub bạn sử dụng lệnh sau :

> $ docker pull alexmyg/andropytool
- Khởi động AndroPyTool bằng cách khởi tạo và chạy Container từ image mà bạn đã pull về :
> 
> 
> `$ docker run --volume=</PATH/TO/FOLDER/WITH/APKS/>:/apksalexmyg/andropytool -s /apks/ <ARGUMENTS>`

- Theo tôi trước khi sử dụng câu lệnh trên bạn nên tạo trước một Volume thay vì mount trực tiếp mỗi lần lại phải chèn path vào.
ví dụ ở đây là tôi sẽ đặt một file apk và cả image của thiết bị android mà bạn sẽ cần ở những bước sau ở `/home/lab` . Tại vì sẽ phát sinh lỗi ở droidbox thầy của tôi đã tìm ra cách fix nó hãy chú ý nhé. Một volume là `disk1` sẽ  được khởi tạo từ  `/home/lab`

> `$ docker volume create --opt device=/home/lab --opt type=none --opt
> o=bind disk1`

Sau đó tôi sẽ chạy AndroPyTool tại host này tôi cũng sẽ tạo một folder lab trong home để mount với disk1: 

    

> `$ docker run -v disk1:/home/lab:/apks alexmyg/andropytool -s /apks/ <ARGUMENTS>`

**Note 1** không được thiếu đối số `-s` trong lệnh trên, nó sẽ trỏ đến thư mục apk nơi sẽ thực thi phân tích.
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
#### B. Cài đặt sử dụng source code
- Cách này nên thực hiện trên Ubuntu 18.04 LTS
**0. Chúng ta cần cài sẵn những gói thư viện và công cụ  sau huẩn bị** 
	- wget 
	- curl
	- git
	- python-dev
	- python-pip
	- gcc
	- python-tk
	- lib32gcc1 
	- lib32ncurses5 
	- lib32stdc++6 
	- lib32z1 
	- libc6-i386 
	- libgl1-mesa-dev 
	 Bằng lệnh sau :
	 
>
    $ sudo apt-get update


>
     $ sudo apt-get install -y --no-install-recommends software-properties-common wget git lib32gcc1 lib32ncurses5 lib32stdc++6 lib32z1 libc6-i386 libgl1-mesa-dev python-pip python-dev gcc python-tk curl

- Cài đặt java 8 và python-setuptool
>
    $ sudo apt install openjdk-8-jdk openjdk-8-jre

> 

    $ sudo apt-get install -y python-setuptools

**1. Cài đặt Android SDK** (chuyển sang bước tiếp theo nếu bạn đã có nó) 
Các bước sau đây dùng để cài đặt SDK Android ở chế độ không có giao diện đồ họa (non-GUI)
-   Tải về và giải nén  Android SDK:
    
>
`$ cd `
>
`$ wget http://dl.google.com/android/android-sdk_r24.2-linux.tgz`
>
 `$ tar -xvf android-sdk_r24.2-linux.tgz`

    
-   Thêm  Android SDK vào `~/.bashrc` 3 dòng dưới đây bằng [Vim](h) hoặc [Nano](h) . Nếu bạn sử dụng  [Zsh](https://github.com/ohmyzsh/ohmyzsh) hãy thêm 3 dòng dưới đây vào file `~/.zshrc`
    
    ```
    export ANDROID_HOME=$HOME/android-sdk-linux/
    export PATH=$PATH:$ANDROID_HOME/tools
    export PATH=$PATH:$ANDROID_HOME/platform-tools
    ```
    
-   Load các thư viện ở phiên hiện tại  :
    

>
   `$ source ~/.bashrc`

**Cài đặt các gói của Android 16**

-   Cài đặt Android 16, phiên bản được hỗ trợ bởi DroidBox (the platform and system image):
>  
 `$ echo y | android update sdk --filter platform-tools --no-ui --force -a`
 >
   `$ echo y | android update sdk --filter tools --no-ui --force -a`
  >
   `$ echo y | android update sdk --filter android-16 --no-ui --force -a`
   >
   `$ echo y | android update sdk --filter sys-img-armeabi-v7a-android-16 --no-ui -a`

**3. Tải source code  và image từ github**

-   Bây giờ chúng ta có thể tải AndroPyTool từ GitHub. 
>
`$ git clone --recursive https://github.com/alexMyG/AndroPyTool.git`
>
`$ wget https://github.com/pjlantz/droidbox/releases/download/v4.1.1/DroidBox411RC.tar.gz`
>
`$ tar -zxvf DroidBox411RC.tar.gz`
>
 `$ cp -r DroidBox_4.1.1/images AndroPyTool/DroidBox_AndroPyTool/images`
 >
`$ touch AndroPyTool/avclass/__init__.py`

- Nếu bạn cài đặt như bước trên thì sẽ xảy ra lỗi ở system image và RAM image chúng không thực sự hoạt động tốt ngay cả khi bạn cài đặt bằng Docker cũng sẽ gặp vấn đề tương tự. Cụ thể lỗi này sẽ phát sinh ở Bước thứ 6 : khi bạn sử dụng Droidbox 

![image](https://user-images.githubusercontent.com/15378788/78069284-e1506b80-73aa-11ea-81bb-5aba647732dd.png)
- Boot không thể thực hiện bởi vì không tìm thấy thiết bị, Thiết bị  được khởi tạo (init) bằng Image của bạn tải về. Cách khắc phục của giảng viên bộ môn an toàn heej điều hành của tôi thầy   [Phạm Hoàng Duy](https://github.com/phamhduy) (Học viện Công nghệ Bưu chính Viễn thông ) như sau thầy tạo một AVD ( Android Virtual Device) mới đổi tên (system.img và ramdisk.img) thay cho file image cũ được tải về từ https://github.com/pjlantz/droidbox/releases/download/v4.1.1/DroidBox411RC.tar.gz 


![](https://i.imgur.com/PNZzSaj.png)

![](https://i.imgur.com/Gxl6jcX.png)
	

>Các file img của droidbox dùng yaffs thay vì ext4 nê nó không chạy với phần mềm mô phỏng của Android .

- Tải lại file image etx4 **[File image](https://drive.google.com/open?id=14azbpTT07ypRH6qEvBN_IxaMErFtvmCw)** 
- Sau đó sao chép hai file này vào thư mục images `/home/erik/AndroPyTool/DroidBox_AndroPyTool/images` chú ý đây là đường dẫn trên máy của tôi còn đường dẫn (path) của bạn sẽ khác phần user trong `/home` thôi.

![](https://i.imgur.com/6cJ0oUH.png)

Như vậy là xong phần Droidbox.

**3. Chuẩn bị Droidbox**

-   Chúng ta sẽ cấp quyền cần thiết cho scripts bằng lệnh **[chmod](h)** 
>
`$ chmod 744 AndroPyTool/DroidBox_AndroPyTool/*.sh`
>
    
-   Tạo thiết bị  Android bằng lệnh sau : "no" là sẽ mặc định là không thay đổi thông số nào khi khởi tạo thiết bị. 
    
   >  
   `$ echo "no" | AndroPyTool/DroidBox_AndroPyTool/createDroidBoxDevice.sh`

**4. Cài đặt các thư viện Python cần thiết**

-   Bạn có thể tùy chọn chạy môi trưởng ảo `virtualenv` hay không đối với máy cấu hình thấp thì không nên vì bước này không thiết yếu lắm, bạn  sử dụng câu lệnh sau để cài đặt :
    
>  
`$ sudo pip install virtualenv`

- Tạo môi trường ảo và kích hoạt :
   
>    
`$ virtualenv droidbox_env`
>     
`$ source droidbox_env/bin/activate`

 - **Cài đặt Wheel**

`$ pip install wheel`

-   **Các thư viện Python cần thiết** đã được liệt kê trong file `requirements.txt`:
>
   `$ pip install -r AndroPyTool/requirements.txt`
    
 
 ![](https://i.imgur.com/j6SKgKg.png)

 **5. Chạy AndroPyTool**

-   Nếu các bước cài đặt đều ổn thì bắt đầu chạy phân tích thôi :
- Di chuyển đến thư mục `/AndroPyTool`
>
`$ cd AndroPyTool/`
>  
`$ python androPyTool.py -s </PATH/TO/FOLDER/WITH/APKS/>`

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

### 2. Sử dụng 
- **Bước 1** : Đăng kí tài khoản **[Virustotal](https://www.virustotal.com)** lấy API key 
![](https://i.imgur.com/4VBw8m2.png)

![](https://i.imgur.com/E0xwiLo.png)
- **Bước 2** : Chuẩn bị file APK để phân tích  

 Dataset được cung cấp bởi đại học **[New Brunwick](https://www.unb.ca/)** ( Canada )

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQXv4FyTpM7wWgoculZZNce5zRm3pAk8qcAG8sRxtfdrTHtCsdx&usqp=CAU"/>

CIC2019 Dataset
https://www.unb.ca/cic/datasets/invesandmal2019.html
http://205.174.165.80/CICDataset/CICInvesAndMal2019/Dataset/APKs/

Nếu bạn thấy Dataset trên chưa thỏa màn nhu cầu phân tích của bạn thì có thể tham khảo Dataset của anh Ấn Độ này.

![](https://i.imgur.com/2nUnnmG.png)

**[Github/ashishb](https://github.com/ashishb/android-malware)**
- **Bước 3 : Phân tích**

  Tôi sẽ chọn `05af60ce8a8c3cd31682982122423ef3.apk` nó là một loại Beanbot thuộc PremiumSMS. Đặt nó trong môt thư mục mới tạo trọng `/home` tên là `lab`  path : `/home/erik/Documents/lab`
 
 ![](https://i.imgur.com/RIsDjb4.png)
 
 - Sau đó là chạy lệnh phân tích với chế độ thực hiện tất cả các bước (nhớ là di chuyển vào trong thư mục `/AndroPyTool` và kèm theo API key):
 >
  `$ cd AndroPyTool/`
>  

    $ python androPyTool.py -s /home/erik/Documents/lab -all -vt f25cfc1b646a0d0eb6437fa7a21db4f9cfc4ef8027c97bd3943428acc5bed2d1

- Các Bước từ 1 đến  5 sẽ thực thi rất nhanh riêng bước 6 thì sẽ mất ít hay nhiều thời gian phụ thuộc vào cấu hình máy tính của bạn. 

**Bước 1 --> 5** 

![](https://i.imgur.com/lp7q9zW.png)

**Bước 6** : thời gian **boot** khá lâu nhưng không phải bị lỗi hoàn toàn đâu. Thông báo lỗi xuất hiện  là khi **[Emulator](h)** đã khởi chạy mà thiết bị vẫn chưa **boot** xong nên nó không tìm thấy.
 
 
![](https://i.imgur.com/j2nqtld.png)

- Trong khi vẫn hiển thị error nhưng **[filesytem](h)** vẫn được khởi tạo nghĩa là có thể thực thi chứ không "chết" hẳn. 


![](https://i.imgur.com/mlWgsD6.png)
- Đây là khi mọi thứ đã hoàn tất **bước 6** và việc trích xuất kết quả ở **bước 7**.

![](https://i.imgur.com/n5hkv3d.png)
## III. Kết quả và nghiệm thu
 ## [](https://github.com/alexMyG/AndroPyTool#input-and-output-folder-structure)1. Cấu trúc thu mục nhập xuất 

**INPUT:** Một thư mục chứa file.apk cần phân tích. **OUTPUT:** Cấu trúc thư mục đầu ra đây các bạn :

```
/                      --> Thư mục gốc (root folder)
/samples/              --> samples, Nơi lưu trữ mấu phân tích
/samples/BW/           --> benignware samples (mẫu bắt đầu đưa vào phân tích)
/samples/MW/           --> Nếu là malware thì file.apk sẽ bị tống vào đây
/invalid_apks/         --> Nơi lưu trữ nhưng file apk không hợp lệ
/VT_analysis/          --> báo cáo phân tích của VirusTotal lưu ở đây
/FlowDroid_outputs/    --> Kết quả phân tích flowDroid
/FlowDroid_processed/  --> ghi lại kết quả trong quá trình flowDoid thực thi
/DroidBox_outputs/     --> DroidBox xuất dữ liệu thô
/Dynamic/Droidbox/     --> Phân tích Droidbox lưu bằng file jason
/Dynamic/Strace/       --> Phân tích dấu vết xuất ra CSV
/Features_files/       --> Các tính năng tệp được tạo bằng AndroPyTool

```
Sau đây tôi sẽ **show** cho các bạn thấy chúng ta nhận được những gì sau khi phân tích "em" beanbot trên:

Trong `/lab` của tôi lúc này là kết quả thu được.


``` total 32
drwxr-xr-x 2 erik erik 4096 Thg 4 29 17:02 DroidBox_outputs
drwxr-xr-x 4 erik erik 4096 Thg 4 29 17:01 Dynamic
drwxr-xr-x 2 erik erik 4096 Thg 4 29 17:02 Features_files
drwxr-xr-x 2 erik erik 4096 Thg 4 29 16:51 FlowDroid_outputs
drwxr-xr-x 2 erik erik 4096 Thg 4 29 17:05 FlowDroid_processed
drwxr-xr-x 2 erik erik 4096 Thg 4 29 16:51 invalid_apks
drwxrwxrwx 4 erik erik 4096 Thg 4 29 16:51 samples
drwxr-xr-x 2 erik erik 4096 Thg 4 29 16:51 VT_analysis
```
 ![](https://i.imgur.com/kHN7m0e.png)
 - Các file dữ liệu thô đều hiển thị đầy đủ.
 Đến đây thì ta đã hoàn thành quá trình phân tích tĩnh và động sử dụng AndroPyTool. Cảm ơn đã theo dõi bài viết này. Chúc các bạn sử dụng AndroPyTool hệu quả.

### Bài viết được tham khảo thông tin từ :
- **[alexMyG/AndroPyTool](https://github.com/alexMyG/AndroPyTool)** 
-  thầy **[Phạm Hoàng Duy](https://github.com/alexMyG/AndroPyTool/issues/19)**
- **[Virustotal](https://www.virustotal.com/)**
- **[Researchgate](https://www.researchgate.net/figure/AndroPytool-architecture_fig1_326717726)**
- **[University of New Brunswick](https://www.unb.ca/cic/datasets/invesandmal2019.html)** 

