#/bin/sh

echo '-----------------------------'
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8000/user/users --data '{"username":"admin"}'

echo '-----------------------------'
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8000/user/users --data '{"username":"guest"}'

echo '-----------------------------'
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8000/team/teams --data '{ "name": "리버풀",  "address": "영국 머지사이드" }'

echo '-----------------------------'
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8000/team/1/teams --data '{"name": "리버풀"}'

echo '-----------------------------'
curl -X GET  http://localhost:8000/user/users/1 

echo '-----------------------------'
curl -X GET  http://localhost:8000/team/1/teams

echo '-----------------------------'
curl -X GET  http://localhost:8000/user/users/resttemplate/1

#curl -X GET  http://localhost:8000/user/users/resttemplate/2

echo '-----------------------------'
curl -X GET  http://localhost:8000/user/users/fegin/1

#curl -X GET  http://localhost:8000/user/users/fegin/2


