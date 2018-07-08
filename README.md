# Project Title

Question service ui provides ui and api for answering a question provided by author 

## Supporting features 
* create a question
* set question div tag header text, font color , font name , div size
* check if user answers are correct 

## Limitations 
* since basic requirements were telling about single question, storage operates only with single question and single config

##  Requirements
```
java >= 1.8
mvn >= 3.5.3

```

## Build and run

```

cd <your_path_to>/ui-0.0.1-SNAPSHOT.jar 

e.g.
cd /Users/aleksandr.velichko/myProj/quiz-service/target/ui-0.0.1-SNAPSHOT.jar 
then 

mvn clean install

then 

cd target 
e.g. 
cd /Users/aleksandr.velichko/myProj/quiz-service/target

then 
java -jar ui-0.0.1-SNAPSHOT.jar

```
## Getting Started for linux and mac

##### if you are using linux or modern mac then you can start your application by execution sh file start.sh
##### this file will build project and launh it 
##### application will be started and start.sh will create first question and window config 
##### previous step not required if you are going to use start.sh
```
cd <your_path_to>/start.sh
e.g. 
cd /Users/aleksandr.velichko/myProj/quiz-service/start.sh

then ./start.sh
```

##### Note: unfortunately due to java linux process specific 
##### skript file execution time will be approximately 20sec 

## Getting Started

##### To start work with the service you need to create your first question 

##### to do that you need to send following request to the backend 

```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: */*' -d '{ 
   "answerDtos": [ 
     { 
       "answer": "2", 
       "correct": false 
     },  
    { 
       "answer": "3", 
       "correct": false 
     },  
    { 
       "answer": "4", 
       "correct": false 
     },  
   { 
       "answer": "6",  
       "correct": true 
     } 
   ], 
   "questionText": "3+3= ?"  }' http://localhost:8080/question/add
```
* "answer": "4" - answer text which will be displayed to the end user 
* "correct": false - answer status , if true then this answer is correct

##### Then you need to specify how does your question window will look like 

##### for dooing that you need to send following request 
```

curl -X POST --header 'Content-Type: application/json' --header 'Accept: */*' http://localhost:8080/ui/config?font=Times%20New%20Roman&color=green&title=question%20title&width=500&height=300
```
* font - font name 
* color - font color
* title - window title which going to be displayed on the top of question div element 
* width - div width
* height - div height   


```
in your browser open 
http://localhost:8080/
```

## Getting Started admin UI 

##### if you dont like to send all previous request using curl you can use embedded swagger ui client for this purposes 

```
please open in your browser 
http://localhost:8080/swagger-ui.html#/
```

```
under question-controller link you will find endpoint with name 
POST /question/add
this endpoint allws you to create question in storage 
```

```
under question-window-controller link you will find endpoint with name 
POST /ui/config
this endpoint allws you to set window config
```

```
in your browser open 
http://localhost:8080/
```


## Service configuration

##### Service configuration can be found in application.yml
##### e.g. /Users/aleksandr.velichko/myProj/quiz-service/src/main/resources/application.yml

Note:
```
quiz-service: 
  url: localhost -host which will be used on UI .html template for ajax
  port: 8080 -port which will be used on UI .html template for ajax

```


## Authors

* **Aleksandr Velichko** - *email* - [mrdezzdemon@gmail.com](mrdezzdemon@gmail.com)
