from wordcloud import WordCloud, STOPWORDS
import matplotlib.pyplot as plt
 
text = open('bible_data_set.csv','r').read()
wordcloud = WordCloud(max_font_size=100,width = 1520, height = 535).generate(text)
plt.figure(figsize=(16,9))
plt.imshow(wordcloud)
plt.axis("off")
plt.savefig('biblia.png')
plt.show()
plt.draw()