# ChatBotFiap Dialogflow

These project demonstrate the use of the [Dialogflow API][dialogflow] to create a chatbot.

## Java Version
This sample requires you to have
[Java11][Java11].

### Download Maven
To get started, [download][maven-download] and [install][maven-install] it.

### Setup

* Create a project with the [Google Cloud Console][cloud-console], and enable the [Dialogflow API][dialogflow-api].
* [Set up][auth] authentication. For example, from the Cloud Console, create a service account, download its json credentials file, then set the appropriate environment variable:
    ```shell
    set GOOGLE_APPLICATION_CREDENTIALS=path/file.json
    ```
    ```shell
    set OPEN-WEATHER-TOKEN=e0d9c4cf8763a9a2575a1b087f10fde3
    ```
    ```shell
    set TELEGRAM-TOKEN=TELEGRAM_TOKEN
    ```
    ```shell
    set GOOGLE_CLOUD_PROJECT=PROJECT_ID
    ```

### Run Application

* In the project path, open the shell console, install the dependencies and run the application:
    ```shell
    mvn clean install -Dmaven.test.skip=true
    ```
    ```shell
    mvn spring-boot:run
    ```

### Telegram bot
* Functions that can be performed in chatbot.
    ```text
    /start    - Iniciar chat
    /weather  - Previsao do tempo
    ```


### Authors:

[Carlos Jr.](https://github.com/cjunior1976) | [Juscelino Carvalho](https://github.com/JuscelinoCarvalho) | [Luan Fernandes](https://github.com/souluanf) | 
[Paulo Bof](https://github.com/paulobof) | [Wesley Guimaraes](https://github.com/wees-guimaraes)


[maven]: https://maven.apache.org
[maven-download]: https://maven.apache.org/download.cgi
[maven-install]: https://maven.apache.org/install.html
[Java11]: https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html
[cloud-console]: https://console.cloud.google.com
[dialogflow-api]: https://pantheon.corp.google.com/apis/library/dialogflow.googleapis.com
[telegram-api]: https://core.telegram.org/bots/api
[auth]: https://cloud.google.com/docs/authentication/getting-started
[dialogflow]: https://dialogflow.com/docs/getting-started/basics
[google-cloud-java]: https://github.com/GoogleCloudPlatform/google-cloud-java
[java-telegram-bot-api]: https://github.com/pengrad/java-telegram-bot-api