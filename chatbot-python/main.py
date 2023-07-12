from bardapi import Bard
import os

from fastapi import FastAPI

app = FastAPI()


@app.post("/chat")
async def root(question: str):
    os.environ['_BARD_API_KEY'] = "Ygi4kJOaim6FKa1qM-7-Ts1uSiJEVF3dR5kBYNT4SWgVB7sjisF68LckNwzh1BHFu8s8DQ."
    print("asasfdasfdf")
    return Bard().get_answer(question)['content']