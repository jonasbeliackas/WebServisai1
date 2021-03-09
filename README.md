# WebServisai TODO List

* build project (i used intelj)

* clean and install maven

* login to docker

* build docker image with this command:
docker build -f Dockerfile -t docker-spring-boot .

* run docker container with this command:
docker run -p 5000:5000 docker-spring-boot

# JSON format
```
{
    "id": 2,
    "title": "do smtg2",
    "done": true
}
```
#### use postman or other program 
# POST
post to this url :
[http://localhost:5000/todo](http://localhost:5000/todo)
* post body looks like this
```
{
    "title": "do smtg2"
}
```
OR
```
}
    "title": "do smtg2",
    "done": true
}
```
# GET
send with get method this url:
[http://localhost:5000/todo](http://localhost:5000/todo)
in order to receive info in json format from database
# PUT
* is used to update list
you need to pass id of which data u want to update
and then change title or done state
```
{
    "id": 2,
    "title": "do smtg2",
    "done": true
}
```
#DELETE
* in order to delete something u need to pass an id into url
[http://localhost:5000/todo/{id}](http://localhost:5000/todo/{id})
* for example: http://localhost:5000/todo/1 u would delete data from database with id - 1
