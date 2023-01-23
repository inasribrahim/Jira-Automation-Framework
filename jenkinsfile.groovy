pipeline {
    agent any

    stages {
        stage('Scan') {
            steps {
               dir('Api-Automation-Framework/Api-Task/'){
                   withSonarQubeEnv(installationName:'sonarQube'){
                bat (''' mvn clean verify sonar:sonar -Dsonar.projectKey=API_Automation  ''')
               } 
                   
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
