import time
import json
import random
import string
from locust import HttpUser, task, between

class QuickstartUser(HttpUser):
    wait_time = between(1, 2)

    @task
    def new_user(self):
        letters = string.ascii_lowercase
        random_str = ''.join(random.choice(letters) for i in range(40))
        headers = {'content-type': 'application/json'}
        email = f"LOCUST{random_str}@email.com"
        data = json.dumps([email,"Sup3rSafeP*ssw0rd","LOCUST TEST","captcha"])
        self.client.post('/api-users/new', data=data, headers=headers, verify=False)
