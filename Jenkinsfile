pipeline{
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
		  stage('Build'){
            steps{
                echo 'Building..cad le compilation de projet ET =>artifact .war/.jar'
                sh  'mvn clean package '

            }
        }
        stage('Deploy to Tomcat') {
    steps {
        script {
            // Le chemin du fichier .war est relatif au workspace Jenkins
            def warFile = 'target/e-commerce-v2-0.0.1-SNAPSHOT.war'
            
            // Le répertoire webapps de Tomcat doit être spécifié ici.
            // **REMPLACEZ** le chemin ci-dessous par le chemin réel de votre dossier webapps !
            def tomcatWebappsDir = '/opt/tomcat/webapps/' 

            echo "Déploiement de ${warFile} vers ${tomcatWebappsDir}..."
            
            // Commande pour copier l'artefact
            sh "cp ${warFile} ${tomcatWebappsDir}" 
            
            echo "Déploiement terminé! Votre application devrait être accessible."
        }
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