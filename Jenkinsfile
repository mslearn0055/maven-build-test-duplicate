@Library('jenkins-shared-libraries') _

pipeline 
{
    agent any

    stages 
    {
        stage('Build') 
        {
            steps 
            {
                mavenBuild()
            }
        }

        stage('Test') 
        {
            steps 
            {
                test()
            }
        }

        stage('Deploy') 
        {
            steps 
            {
                echo 'Deploy new  App'
            }
        }
    }

    post
    {

    	always
    	{
    		emailext body: 'Summary', subject: 'Pipeline Status', to: 'selenium3bymukesh@gmail.com'
    	}

    }
}
