pipeline {
    agent any

    tools {
        jdk 'jdk-12'
		maven 'maven'
    }

    stages {
        stage('Build Project') {
            steps {
                
				sh 'mvn clean install -DskipTests'
				
            }
        }
        stage('Api') {
            steps {
                sh 'mvn clean test -pl :api'
            }
        }
        stage('Domain') {
            steps {
                sh 'mvn clean test -pl :domain'
            }
        }
        stage('Service') {
            steps {
                sh 'mvn clean test -pl :service'
            }
        }
        stage('Infrastructure') {
            steps {
                sh 'mvn clean test -pl :infrastructure'
            }
        }
    }
}
