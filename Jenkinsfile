pipeline{
	agent any
	stages{
		stage("Clone"){
			steps{
			echo " Depot git cloner => success :)"
            git branch:"master", url: 'https://github.com/FatenBahri/e-commerce-store.git'
		}}
		  stage('Build'){
            steps{
                echo 'Building..cad le compilation de projet ET =>artifact .war/.jar'
                sh  "mvn clean package && mvn install"

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