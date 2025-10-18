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
    // Dans votre Jenkinsfile:
stage('Deploy to Tomcat') {
    steps {
        script {
            def warFile = 'target/e-commerce-v2-0.0.1-SNAPSHOT.war'
            def tomcatWebappsDir = '/mnt/c/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/' 

            echo "Déploiement et renommage en ecom.war..."
            
            // Renomme le fichier pendant la copie pour obtenir l'URL /ecom
            sh "cp ${warFile} ${tomcatWebappsDir}ecom.war" 
            
            echo "Déploiement terminé. L'URL est maintenant /ecom."
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