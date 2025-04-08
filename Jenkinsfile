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
               sh 'mvn clean install'            }
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
                deploy()
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
