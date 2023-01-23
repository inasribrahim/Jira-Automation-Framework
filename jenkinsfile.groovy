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
         stage('Qualtiy Qate') {
                 timeout(time:2 , unit: 'MINUTES'){
                    def qualtiyGate = waitForQualityGate();

                    if (qualtiyGate.status() != 'OK')
                     {
                        error "Pipeline abroted due to quality gate not passed :(s"
                     }
                 }
             
         }
    }
}
