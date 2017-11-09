## snakehack-java

A basic snakehack starter kit written in java using maven, grizzly and jersey.


### How to start

1) [Fork this repo](https://github.com/stair-ch/snakehack-java/fork).

2) Clone repo to your development environment:
```
git clone git@github.com:USERNAME/snakehack-java.git $GOPATH/github.com/USERNAME/snakehack-java
cd $GOPATH/github.com/USERNAME/snakehack-java
```

3) Import the project into your ide. This repos uses intellij.

4) Run the RestInPeace server
6) Test the client in your browser: [http://127.0.0.1:4242](http://127.0.0.1:4242)

### Heroku
[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

#### Heroku-cli commands
create new heroku app, `--region eu` is important for fast enough response times
```
heroku create --region eu
```
push to heroku
```
git push heroku master
```
delete heroku git
```
git remote rm heroku
```
