
pipeline {

    agent any

    environment {

        JFROG_CLI_BUILD_NAME = "${env.JOB_NAME}"

        JFROG_CLI_BUILD_NUMBER = "${env.BUILD_NUMBER}"

    }

    stages {

        stage ('Run JFrog CLI') {

            steps {

                sh 'jfrog rt mvn -f /path/to/pom.xml clean install' // build & deploy artifacts

                sh 'jfrog rt bp' // publish build info

            }

        }

    }

}
