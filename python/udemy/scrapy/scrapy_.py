import scrapy

class GilenoFilhoSpider(scrapy.Spider):

    name = 'gilenofilho'
    start_urls = ['http://www.gilenofilho.com.br']

    def parse(self, response):
        self.log('Hello....')
        self.log(response.body)