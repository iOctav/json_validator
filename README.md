# JSON Validation Service
The JSON Validation Service (JVS) is a validator that allows every users to check JSON objects
## Handling the Responses

1. If received JSON is valid, it is formatted to human-readable form and sent back.

2. If data in a request is not conform to the JSON grammar, the following response is sent:

    ```json
     {
         "errorMessage" : "plain language description of the problem",
         "errorPlace" : "the point where error has occurred"
     }
     ```

## Deployment

Build gradle package and run Docker image:

```shell
$ ./gradlew build docker
$ docker run -d -p 80:80 kspt.spbstu/json_validator
```

To test that JVS is working properly, make a POST request as shown below:

```shell
s curl -s --data-binary @filename.json http://localhost:80
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details