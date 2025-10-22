pipeline {
	agent any
	stages{
		stage("Clone"){
			steps{
			echo " Depot git cloner => success :)"
            git branch:"master", url: 'https://github.com/FatenBahri/e-commerce-store.git'
		}}
		 stage('Check Environment') {
            steps {
				echo'verif'
                sh 'mvn -v'
           }
       }
         stage('Test'){
            steps{
                echo 'partie test junit+cucumber'
              //  sh 'mvn test' ou mvn clean test ou mvn clean verify
                
            }
        }
		  stage('Build'){
            steps{
                echo 'Building..cad le compilation de projet ET =>artifact .war/.jar'
                //mvn package :exécute par défaut les tests JUnit/Cucumber. 
				// Donc même si tu ne les lances pas dans ton stage Test, ils vont tourner pendant le package.
                sh 'mvn clean package -DskipTests'//compile les tests mais ne les exécute pas.
            }
        }
    
        // STAGE DE DÉPLOIEMENT : C'EST ICI QUE LE FICHIER EST COPIÉ de jenkins location VERS WINDOWS
        
       stage('Deploy') {
    steps {
		echo 'done'
        sh 'cp target/e-commerce-v2-0.0.1-SNAPSHOT.war /var/lib/tomcat10/webapps/'
    }
}


	}
	post{
            success{
                echo 'Pipeline executed successfully!'
            }
            failure{
                echo 'Pipeline failed. '
            }
        }
}
