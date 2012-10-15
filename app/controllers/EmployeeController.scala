package controllers

import play.api.mvc.{Controller, Action}
import play.api.data.Forms._
import play.api.data.Form
import models.Employee

object EmployeeController extends Controller{

  def show(id: Int) = Action {
    Ok("id = " + id)
  }

  def hello = Action { implicit request =>
    //employee = employeeForm.bindFromRequest.get
    Ok("")
  }

  def input = Action {
    Ok(views.html.form(employeeForm))
  }

  def register = Action { implicit request =>
    employeeForm.bindFromRequest.fold(
      errors => BadRequest(views.html.form(errors)),
      employee => {
        Ok(views.html.result())
      }
    )
  }

  val employeeForm = Form(
    mapping(
      "name" -> text,
      "mail" -> optional(email),
      "age"  -> number
    )(Employee.apply)(Employee.unapply)
  )

  val employeeTuple = Form(
    tuple(
      "name" -> text,
      "mail" -> optional(email),
      "age" -> number
    )
  )
}




