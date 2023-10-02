FROM python:3.9

ADD . /usr/lib/
WORKDIR /usr/lib/


RUN pip install -r requirements.txt

EXPOSE 5000

CMD [ "python","main.py" ]