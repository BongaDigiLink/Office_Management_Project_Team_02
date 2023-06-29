import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomBookingInputComponent } from './room-booking-input.component';

describe('RoomBookingInputComponent', () => {
  let component: RoomBookingInputComponent;
  let fixture: ComponentFixture<RoomBookingInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoomBookingInputComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RoomBookingInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
