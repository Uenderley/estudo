# -*- coding: utf-8 -*-
import scrapy


class CourseraSpider(scrapy.Spider):
    name = 'coursera'
    start_urls = ['https://pt.coursera.org']

    def parse(self, response):
        self.log('Hello Coursera')
        self.log(response.body)
