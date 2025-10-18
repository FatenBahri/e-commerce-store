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
        
        stage('Deploy') {
    steps {
        sh 'cp target/e-commerce-v2-0.0.1-SNAPSHOT.war "C:/Users/faten/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/"'
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
