import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { IClient, Client } from '../client.model';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'jhi-client-update',
  templateUrl: './client-update.component.html',
})
export class ClientUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    designation: [],
    contact: [],
    postec: [],
    email: [],
    tel: [],
    adresse: [],
    besoins: [],
    remarques: [],
    forum: [],
  });

  constructor(protected clientService: ClientService, protected activatedRoute: ActivatedRoute, protected fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ client }) => {
      this.updateForm(client);
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const client = this.createFromForm();
    if (client.id !== undefined) {
      this.subscribeToSaveResponse(this.clientService.update(client));
    } else {
      this.subscribeToSaveResponse(this.clientService.create(client));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IClient>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(client: IClient): void {
    this.editForm.patchValue({
      id: client.id,
      designation: client.designation,
      contact: client.contact,
      postec: client.postec,
      email: client.email,
      tel: client.tel,
      adresse: client.adresse,
      besoins: client.besoins,
      remarques: client.remarques,
      forum: client.forum,
    });
  }

  protected createFromForm(): IClient {
    return {
      ...new Client(),
      id: this.editForm.get(['id'])!.value,
      designation: this.editForm.get(['designation'])!.value,
      contact: this.editForm.get(['contact'])!.value,
      postec: this.editForm.get(['postec'])!.value,
      email: this.editForm.get(['email'])!.value,
      tel: this.editForm.get(['tel'])!.value,
      adresse: this.editForm.get(['adresse'])!.value,
      besoins: this.editForm.get(['besoins'])!.value,
      remarques: this.editForm.get(['remarques'])!.value,
      forum: this.editForm.get(['forum'])!.value,
    };
  }
}
