package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  /*
  クエリ文字列を引数にマッピング
   */
  /*
  def hello(name: String) = Action {
    Ok("hello " + name)
  }
  */

  /*
  アクションメソッド内でリクエストパラメータを受け取る場合 クエリ文字列
   */
  /*
  def hello = Action { request =>
    val params: Map[String, Seq[String]] = request.queryString
    val name = params("name").head

    Ok(<h1>Hello {name}!</h1>).as(HTML)
  }
  */

  /*
  アクションメソッド内でリクエストパラメータを受け取る場合 POST
   */
  def hello = Action { request =>
    val formBody: Option[Map[String, Seq[String]]] = request.body.asFormUrlEncoded
    val params: Map[String, Seq[String]] = formBody.get
    val name = params("name").head

    Ok(<h1>Hello {name}!</h1>).as(HTML)
  }
  
}