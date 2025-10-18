pipeline{
	agent :any
	stages{
		stage("Clone"){
			steps{
			echo "depot git cloner => success"
			sh "git clone https://github.com/FatenBahri/e-commerce-store.git"
		}}
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