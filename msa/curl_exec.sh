#/bin/sh
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8000/user/users --data '{"username":"devsunset"}'

curl -X POST -H 'Content-Type: application/json' -i http://localhost:8000/team/teams --data '{ "name": "리버풀",  "address": "영국 머지사이드" }'

curl -X POST -H 'Content-Type: application/json' -i http://localhost:8000/team/1/teams --data '{"name": "리버풀"}'

curl -X GET  http://localhost:8000/user/users/1 

curl -X GET  http://localhost:8000/team/1/teams



