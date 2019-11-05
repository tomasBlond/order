pipeline {
    agent any

    tools {
        jdk 'jdk-12.0.2'
    }

    stages {
        stage('Build Project') {
            steps {
                
				bat 'mvn clean install -DskipTests'
				
            }
        }
        stage('Api') {
            steps {
                bat 'mvn clean test -pl :api'
            }
        }
        stage('Domain') {
            steps {
                bat 'mvn clean test -pl :domain'
            }
        }
        stage('Service') {
            steps {
                bat 'mvn clean test -pl :service'
            }
        }
    }
}
