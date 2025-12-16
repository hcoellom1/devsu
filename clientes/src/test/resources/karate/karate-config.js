function fn(){
    var env = karate.env;
    if(!env){
        env="dev";
    }

    var config={
        baseUri : 'http://localhost:8080',
        timeout: 5000
    }
}