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
            def warFile = 'target/e-commerce-v2-0.0.1-SNAPSHOT.war'
            
            // NOUVEAU CHEMIN: Utilisation du répertoire de déploiement d'Eclipse WTP
            def tomcatWebappsDir = '/mnt/c/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/' 

            echo "Déploiement de ${warFile} vers ${tomcatWebappsDir}..."
            
            // La commande de copie
            sh "cp ${warFile} ${tomcatWebappsDir}" 
            
            echo "Déploiement terminé! Vérifiez les permissions si ça échoue à nouveau."
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