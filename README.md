# Dialogflow API Spring chatbot

These project demonstrate the use of the [Dialogflow API][dialogflow] to create a chatbot.

[dialogflow]: https://dialogflow.com/docs/getting-started/basics
[google-cloud-java]: https://github.com/GoogleCloudPlatform/google-cloud-java

## Java Version

This sample requires you to have
[Java11](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html).

### Download Maven

To get started, [download][maven-download] and [install][maven-install] it.

[maven]: https://maven.apache.org
[maven-download]: https://maven.apache.org/download.cgi
[maven-install]: https://maven.apache.org/install.html

### Setup

* Create a project with the [Google Cloud Console][cloud-console], and enable
  the [Dialogflow API][dialogflow-api].
* [Set up][auth] authentication. For
    example, from the Cloud Console, create a service account,
    download its json credentials file, then set the appropriate environment
    variable:

    ```cmd
    set GOOGLE_APPLICATION_CREDENTIALS=path/file.json
    ```
    ```cmd
    set OPEN-WEATHER-TOKEN=OPEN_WEATHER_TOKEN
    ```
    ```cmd
    set TELEGRAM-TOKEN=TELEGRAM_TOKEN
    ```
* In our project the json are in src/main/resources
* To run tests, set GOOGLE_CLOUD_PROJECT to your PROJECT_ID:
  ```
  set GOOGLE_CLOUD_PROJECT=PROJECT_ID
  ```
  ```
  mvn clean verify
  ```
* Set PROJECT_ID in pom.xml to your Google Cloud Project Id.

[cloud-console]: https://console.cloud.google.com
[dialogflow-api]: https://pantheon.corp.google.com/apis/library/dialogflow.googleapis.com
[telegram-api]: https://core.telegram.org/bots/api
[auth]: https://cloud.google.com/docs/authentication/getting-started

