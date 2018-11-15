create-cluster: build-jar
	docker build -t pokemon-bff-image .; \
	  docker tag pokemon-bff-image valentinsvt/demo:latest; \
	  docker push valentinsvt/demo:latest; \
	  kubectl create -f deployment.yaml; \
	  kubectl expose deployment pokemon-bff-deployment --type=LoadBalancer;

update-cluster:
	kubectl set image deployment/pokemon-bff-deployment pokemon-bff-container=valentinsvt/demo:latest

destory-cluster:
	kubectl delete service pokemon-bff-deployment; kubectl delete deployment pokemon-bff-deployment; kubectl delete pods -l label=pokemon-bff

build-docker: build-jar
	docker build -t pokemon-bff-image .; \
	  docker tag pokemon-bff-image valentinsvt/demo:latest; \
	  docker push valentinsvt/demo:latest; \

build-jar:
	./gradlew clean build