# openjdk:8-jre-alpine 이미지를 기본으로 사용
FROM openjdk:17-alpine

# jar 파일이 복사되고, docker image를 구성하면서 명령어를 실행하면서 지지고 볶을 디렉토리 설정
ENV APP_HOME=/usr/app/

# 해당 디렉토리에서 작업을 시작하겠다는 구문
WORKDIR $APP_HOME

# jar 파일을 복사한다.
COPY build/libs/*.jar application.jar

# 어플리케이션 포트쓰~
EXPOSE 8080

CMD ["java", "-jar", "application.jar"]