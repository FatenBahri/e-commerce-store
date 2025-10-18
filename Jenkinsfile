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
    
        // STAGE DE DÉPLOIEMENT : C'EST ICI QUE LE FICHIER EST COPIÉ VERS WINDOWS
        stage('Deploy to Tomcat') {
            steps {
                script {
                    def warFile = 'target/e-commerce-v2-0.0.1-SNAPSHOT.war'
                    
                    // 💥 CHEMIN CORRIGÉ CRITIQUE
                    def tomcatWebappsDir = '/mnt/c/pragrammation/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/' 

                    echo "Déploiement et renommage en ecom.war vers le chemin WTP..."
                    
                    // Commande de copie qui rend le fichier visible sur Windows
                    sh "cp ${warFile} ${tomcatWebappsDir}ecom.war" 
                    
                    echo "Déploiement terminé. Vérifiez ce chemin sur votre disque C : ${tomcatWebappsDir}"
                }
            }
        }
        
        stage('Clean Workspace') {
            steps {
                echo 'Nettoyage du dossier target dans l\'espace de travail Jenkins...'
                sh 'rm -rf target'
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
