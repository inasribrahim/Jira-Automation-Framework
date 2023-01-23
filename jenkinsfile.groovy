pipeline {
    agent any

    stages {
        stage('Scan') {
            steps {
                   withSonarQubeEnv(installationName:'sonarQube'){
                bat (''' mvn clean verify sonar:sonar -Dsonar.projectKey=API_Automation  ''')
 
               }
            }
        }
        //  stage('Qualtiy Qate') {
        //      steps{
        //          timeout(time:10 , unit: 'MINUTES'){
        //              waitForQualityGate abortPipeline:true
        //          }
        //      }
        //  }
    }
}
