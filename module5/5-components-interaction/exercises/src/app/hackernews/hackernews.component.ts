import { Component, OnInit } from '@angular/core';
import { Article } from './article';
import { articleList } from './articleList';

@Component({
  selector: 'app-hackernews',
  templateUrl: './hackernews.component.html',
  styleUrls: ['./hackernews.component.css']
})

export class HackernewsComponent implements OnInit {

  constructor() { }

  article = {
    title: 'The Evolution of Async JavaScript: From Callbacks, to Promises, to Async/Await',
    url: 'https://medium.freecodecamp.org/the-evolution-of-async-javascript-from-callbacks-to-promises-to-async-await-e73b047f2f40'
  };
  articles = articleList ;
  articleForm: Article = {
    title: '',
    url: ''
  } ;
  ngOnInit(): void {
  }

  updateArticle() {
    this.article.title = (document.getElementById('article-title') as HTMLInputElement).value;
    this.article.url = (document.getElementById('article-url') as HTMLInputElement).value;
  }

  handleViewClick(art: Article) {
    this.article = art ;
    this.article.title = (document.getElementById('art-title') as HTMLInputElement).value;
    this.article.url = (document.getElementById('art-url') as HTMLInputElement).value;
  }

  handleClick() {
    articleList.push(this.articleForm);
    this.articles = articleList;
    this.articleForm = {
      title: '',
      url: ''
    };
  }
}
