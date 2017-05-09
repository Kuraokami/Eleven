pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo '---------- Begin Construction --------'
        timeout(time: 5, unit: 'MINUTES') {
          sh '''mvn clean compile
'''
        }
        
      }
    }
    stage('Test') {
      steps {
        sh 'mvn install'
      }
    }
  }
}