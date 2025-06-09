FROM postgres:16

# Criação de usuário não root
ENV POSTGRES_USER=safezone_user
ENV POSTGRES_PASSWORD=safezone_pass
ENV POSTGRES_DB=safezone_db

USER postgres
WORKDIR /var/lib/postgresql/data
EXPOSE 5432