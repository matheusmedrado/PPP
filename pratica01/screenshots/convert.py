import base64
import sys
from pathlib import Path

def image_to_base64_markdown(image_path):
    with open(image_path, "rb") as image_file:
        encoded_string = base64.b64encode(image_file.read()).decode('utf-8')
        return f"![image](data:image/png;base64,{encoded_string})"

# Caminho completo para a pasta screenshots
screenshots_dir = Path("/home/matheus/Documents/PPP/ppp/pratica01/screenshots")

# Lista de imagens para converter
images = ["1.png", "2.png", "3.png", "4.png", "5.png", "log.png"]

for img in images:
    img_path = screenshots_dir / img
    if img_path.exists():
        print(f"\n--- {img} ---")
        print(image_to_base64_markdown(img_path))
    else:
        print(f"Arquivo não encontrado: {img_path}")