<%@ page import="geb.parallel.gradle.Author" %>



<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="author.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${authorInstance?.firstName}" id="firstNameField"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="author.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${authorInstance?.lastName}" id="lastNameField"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'books', 'error')} ">
	<label for="books">
		<g:message code="author.books.label" default="Books" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${authorInstance?.books?}" var="b">
    <li><g:link controller="book" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="book" action="create" params="['author.id': authorInstance?.id]">
  ${message(code: 'default.add.label', args: [message(code: 'book.label', default: 'Book')])}
</g:link>
</li>
</ul>

</div>

