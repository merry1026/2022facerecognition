# 얼굴인식 스마트 도어락
| **캡스톤 디자인** 우수상 수상🥈  |**창의융합성과 경진대회(C&C Festival)** 동상 수상🥉 |
|--|--|
|<p align="center"><image src = "https://user-images.githubusercontent.com/77915491/161306726-f2701521-9e86-461a-b19f-0e231253adf3.jpg" width="90%" alt="1"></p>|<p align="center"><image src = "https://user-images.githubusercontent.com/77915491/161298808-ace646c9-f77c-4cb9-b979-043c63c8c2ba.jpg" width="80%" alt="1"></p>|







   
  


### 개발개요

   제4차산업혁명의 핵심기술 중 하나로 언급되는 IoT 기술을 활용하여 사용자에게 더욱더 높은 편리성과 보안성을 갖춘 스마트 도어락을 보급하는 데 그 목적이 있다. 또한, 기존의 도어락을 비교적 저렴한 가격에 얼굴인식 기능이 탑재된 스마트 도어락으로 업그레이드 할 수 있는 시스템, 도어락과 관련된 다양한 기능을 제공하는 관리자용 애플리케이션을 개발함으로써 사용자의 편리성을 극대화하고 가격 접근성을 높이는 데에 최종적인 목적이 있다.



### 프로젝트 설명 및 구조
![image](https://user-images.githubusercontent.com/77915491/120919015-61cad480-c6f2-11eb-9857-649c1962a12c.png)  


앱에서 사용자 등록, 도어락 제어, 사용자 목록, 방문자 목록을 볼 수 있고, Firebase를 통해서 라즈베리파이와 통신을 한다. 도어락과 라즈베리파이는 릴레이모듈을 통해 통신한다. 라즈베리파이에서는 초음파 센서를 이용하여 거리를 계산해 사람을 감지하고, 사용자의 얼굴이 등록된 사용자인지 구분하고 사진으로는 출입이 불가능하게 눈 깜빡임을 감지해야 출입이 가능하다.



### 실행 방법  

- __사용자 등록__    
![image](https://user-images.githubusercontent.com/77915491/120920426-ac9c1a80-c6f9-11eb-8fe4-ad900fc4d668.png)    
앱에서 카메라를 이용하여 얼굴을 촬영하고 이름을 입력한 후, 업로드를 하면 Firebase에 업로드가 되고 이를 라즈베리파이에서 다운을 받고 사용자로 저장한다. 
    

- __실시간 얼굴 인식__  
![open](https://user-images.githubusercontent.com/77915491/120920298-0c45f600-c6f9-11eb-8808-9ed42312314a.GIF)  
초음파 센서를 이용해서 거리를 측정을 하고, 50cm이하로 가까워지게 되면 얼굴을 감지한다.  
얼굴을 감지하면 등록된 사용자인지 구분을 하고, 눈 깜빡임을 감지하여 사진인지 실제 사람인지 구분을 한다.  
등록된 사용자면 문이 열린다.  

- 앱 설명  
     -  __도어락 제어__  
    ![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/77915491/120920637-c12ce280-c6fa-11eb-9e5d-4d701e66428f.gif)

     버튼을 눌러 라즈베리파이의 릴레이모듈을 통해 도어락을 제어한다.  
     지문 인식 기능을 추가하여서 보안성을 높였다.  

     -  __사용자 관리__  
     ![image](https://user-images.githubusercontent.com/77915491/120920380-68a91580-c6f9-11eb-8101-35f97541df84.png)    
     사용자를 추가할 수 있으며 도어락에 등록된 사용자를 확인할 수 있다.   
     
     
  
     -  __출입 기록__  
     ![ezgif com-gif-maker](https://user-images.githubusercontent.com/77915491/120920593-80cd6480-c6fa-11eb-8f71-94a6cd063fb1.gif)  
  
     라즈베리파이에서 도어락에 출입시도를 한 사람을 카메라로 촬영하여 알림과 함께 전송한다. 출입 기록 또한 확인 가능하다.



### 하드웨어 모습
![image](https://user-images.githubusercontent.com/77915491/120919068-aa828d80-c6f2-11eb-804a-cc888a084983.png)
![image](https://user-images.githubusercontent.com/77915491/120919040-87f07480-c6f2-11eb-84b3-b7d062319549.png)





### 사용 도구

| **개발언어**  | **Java, Python**           |
| ------------- | -------------------------- |
| **개발도구**  | **Android studio, Python** |
| **사용 기술** | **landmark, opencv**       |
