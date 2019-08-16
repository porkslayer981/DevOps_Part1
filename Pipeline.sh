pipeline {
    agent any 
    tools {
        maven 'mvn3'
        jdk 'jdk8202'
    }
    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-ssh', url: 'git@github.com:username/checkstyle.git'
            }
        }
        stage('Build') {
            parallel {
                stage('Maven build') {
                    steps {
                        sh "mvn clean install"    
                    }
                }
                stage('Checkstyle') {
                    steps {
                        sh "mvn checkstyle:check"
                        recordIssues(tools: [checkStyle(reportEncoding: 'UTF-8')])
                    }
                }
            }
        }
    }
}