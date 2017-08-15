CS502 HW1 - RunningInformationAnalysisService

Running Instruction:
1. Compile:
	mvn clean install
2. Start MySQL:
	docker-compose up
3. Get into targer directory:
	cd target
4. Start program:
	java -jar running-information-analysis-service-1.0.0.BUILD-SNAPSHOT.jar

REST API:
1. Insert new records into DB
RequestMethod.Post
http://localhost:8080/upload

2. Get n-th page with n = {page}, 2 records per page
RequestMethod.GET
http://localhost:8080/info/{page}

3. Delete by running ID
RequestMethod.DELETE
http://localhost:8080/purge/{runningId}

4. Delete all records
RequestMethod.DELETE
http://localhost:8080/purge


Author: Xiaoyi Yu