build-image:
	@ docker build -f devops/Dockerfile -t grupo2backend:1 .
volume:
	@ docker volume create pg_tendencia_grupodos
deploy:
	@ docker stack deploy --with-registry-auth -c devops/stack.yml grupodos
rm:
	@ docker stack rm grupodos