#!/usr/bin/env groovy

def call(){
  pipeline {
    agent { label 'aws' }

    stages {
        stage('Install-Nginx') {
            steps {
                sh "ls -l"
                sh "sudo yum -y update"
                sh "sudo yum install -y nginx"
            }
        }
        stage('Start-Nginx') {
            steps {
                sh "sudo systemctl enable --now nginx"
            }
        }
        stage('Test-Nginx') {
            steps {
                sh "curl localhost"
            }
        }
    }
  }
}
