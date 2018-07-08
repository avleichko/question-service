#!/bin/bash

mvn clean install

cd target

java -jar ui-0.0.1-SNAPSHOT.jar&
pid=$!

sleep 20

curl -vvv -X POST --header 'Content-Type: application/json' --header 'Accept: */*' -d '{
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


curl -vvv -X POST --header 'Content-Type: application/json' --header 'Accept: */*' 'http://localhost:8080/ui/config?font=Times%20New%20Roman&color=green&title=question%20title&width=500&height=300'

wait $pid

