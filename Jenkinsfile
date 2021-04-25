pipeline {
    agent any
	tools { 
        maven 'Maven' 
        jdk 'jdk8' 
    }
    stages {
    	stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn -Dmaven.test.failure.ignore=true install'
                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Stop') {
            steps {
                echo 'Stopping....'
            }
        }
        stage('Start') {
            steps {
                echo 'Starting....'
                sh 'pwd'
                sh './executeScript.sh'
            }
        }
    }
}