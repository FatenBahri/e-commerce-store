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
                    
                    // 💥 CORRECTION MAJEURE: Utilisation du chemin WTPWEBAPPS et du répertoire 'pragrammation'
                    def tomcatWebappsDir = '/mnt/c/pragrammation/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/' 

                    echo "Déploiement et renommage en ecom.war vers le chemin WTP..."
                    
                    // Renomme le fichier pendant la copie pour obtenir l'URL /ecom
                    sh "cp ${warFile} ${tomcatWebappsDir}ecom.war" 
                    
                    echo "Déploiement terminé. L'URL est http://localhost:8081/ecom."
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
