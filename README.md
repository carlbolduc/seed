# Seed

## Requirements

Seed is in Java, it runs on the JVM. We recommend using any version of the JDK from 11 and up. You can consult the [whichjdk](https://whichjdk.com/) website to decide which version to use.

## Getting Started

1. Download dependencies and create the SQLite database:

`./gradlew dbMigrate`

2. Start the server:

`./gradlew run`

3. Go to http://localhost:8080 and you'll see the website.

## Deployment

1. To create the jar file ready for deployment, build the project:

`./gradlew build`

2. Deploy seed.jar (located in app/build/libs) together with config.yml and seed.db to your server. Modify and use the seed.service file to manage the seed application on your server.

## License

Seed is released under the [MIT License](https://opensource.org/licenses/MIT).
