import os
from moviepy.editor import VideoFileClip, concatenate_videoclips


def juntarVideossss():
    clip1 = VideoFileClip("myvideo.mp4")
    clip2 = VideoFileClip("myvideo2.mp4").subclip(50,60)
    clip3 = VideoFileClip("myvideo3.mp4")
    final_clip = concatenate_videoclips([clip1,clip2,clip3])
    final_clip.write_videofile("my_concatenation.mp4")

def juntarVideos():
    path = '/home/uenderley/Vídeos/MarcioMicheli/ClubEvo/Introdução/'
    lista_arquivos = []
    for filename in os.listdir(path):
        if filename.endswith(".mp4"):
            print (filename)
            lista_arquivos.append(VideoFileClip(path + filename))
    
    print(lista_arquivos)

    final_clip = concatenate_videoclips(lista_arquivos)
    final_clip.write_videofile(path + "my_concatenation.mp4")

juntarVideos()
             
